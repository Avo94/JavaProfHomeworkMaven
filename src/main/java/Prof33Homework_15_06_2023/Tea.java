package Prof33Homework_15_06_2023;

import java.util.UUID;

public class Tea {

    private String uuid;
    private String name;

    private Tea(String uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public Tea(String name) {
        this(UUID.randomUUID().toString(), name);
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "id='" + uuid + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}