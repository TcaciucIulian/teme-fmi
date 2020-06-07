package jobs.model;

import csv.CsvTypeFactory;

import java.util.Objects;

public final class Name {
    public final String first;
    public final String initialOfFather;
    public final String last;

    public final static CsvTypeFactory<Name> FACTORY = new CsvTypeFactory<Name>() {
        @Override
        public String[] getColumnNames() {
            return new String[] { "first", "initial", "last" };
        }

        @Override
        public String[] toStringArray(Name name) {
            return new String[] { name.first, name.initialOfFather, name.last };
        }

        @Override
        public Name fromStringArray(String[] data) {
            return new Name(data[0], data[1], data[2]);
        }
    };

    public Name(String first, String last) {
        this(first, "", last);
    }

    public Name(String first, String initialOfFather, String last) {
        Objects.requireNonNull(first);
        Objects.requireNonNull(initialOfFather);
        Objects.requireNonNull(last);

        this.first = first;
        this.initialOfFather = initialOfFather;
        this.last = last;
    }

    public boolean hasInitialOfFather() {
        return !this.initialOfFather.equals("");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return first.equals(name.first) &&
                initialOfFather.equals(name.initialOfFather) &&
                last.equals(name.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, initialOfFather, last);
    }

    @Override
    public String toString() {
        return first + " " + (hasInitialOfFather() ? initialOfFather + " " : "") + last;
    }
}
