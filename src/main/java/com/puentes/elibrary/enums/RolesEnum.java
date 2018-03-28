package com.puentes.elibrary.enums;

public enum RolesEnum {

    ADMIN (1, "Admin"),
    USER (2, "User");

    private final int id;
    private final String name;

    RolesEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "RolesEnum{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


}
