/*
 * This file is generated by jOOQ.
 */
package ch.metamodel.tables.records;


import ch.metamodel.tables.Test;

import java.time.LocalDateTime;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TestRecord extends UpdatableRecordImpl<TestRecord> implements Record2<Integer, LocalDateTime> {

    private static final long serialVersionUID = -370349948;

    /**
     * Setter for <code>public.test.test_uuid</code>.
     */
    public void setTestUuid(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.test.test_uuid</code>.
     */
    public Integer getTestUuid() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.test.date</code>.
     */
    public void setDate(LocalDateTime value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.test.date</code>.
     */
    public LocalDateTime getDate() {
        return (LocalDateTime) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Integer, LocalDateTime> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Integer, LocalDateTime> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Test.TEST.TEST_UUID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<LocalDateTime> field2() {
        return Test.TEST.DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getTestUuid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime component2() {
        return getDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getTestUuid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime value2() {
        return getDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TestRecord value1(Integer value) {
        setTestUuid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TestRecord value2(LocalDateTime value) {
        setDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TestRecord values(Integer value1, LocalDateTime value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TestRecord
     */
    public TestRecord() {
        super(Test.TEST);
    }

    /**
     * Create a detached, initialised TestRecord
     */
    public TestRecord(Integer testUuid, LocalDateTime date) {
        super(Test.TEST);

        set(0, testUuid);
        set(1, date);
    }
}
