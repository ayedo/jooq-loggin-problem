package ch

import org.jooq.ExecuteContext
import org.jooq.conf.Settings
import org.jooq.impl.DSL
import org.jooq.impl.DefaultExecuteListener
import org.jooq.tools.StringUtils
import org.slf4j.LoggerFactory

class SqlLogger : DefaultExecuteListener() {

    private val log = LoggerFactory.getLogger(this::class.java)

    override fun resultEnd(ctx: ExecuteContext) {

        val create = DSL.using(ctx.dialect(), Settings().withRenderFormatted(true))

        val query = when {
            ctx.query() != null -> create.renderInlined(ctx.query())
            ctx.routine() != null -> create.renderInlined(ctx.routine())
            !StringUtils.isBlank(ctx.sql()) -> ctx.sql()
            else -> null
        }

        val cleanQuery = query?.replace("\"", "")?.replace("public.", "") ?: "Unknown Query"

        val result: String = ctx.result()?.formatCSV() ?: "No Result"

        log.info("\n$cleanQuery\n-\n$result")
    }
}