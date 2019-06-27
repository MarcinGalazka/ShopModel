package shop.model;

import java.util.Objects;

public class Company extends Customer {

    private final String name;
    private final String nip;

    public Company(String name, String nip) {
        this.name = name;
        this.nip = nip;
    }

        public String getName() {
        return null;
    }

    public String getNip() {
        return nip;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(name, company.name) &&
                Objects.equals(nip, company.nip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nip);
    }
}
