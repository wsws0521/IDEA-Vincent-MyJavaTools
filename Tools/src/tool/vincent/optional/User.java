package tool.vincent.optional;

import java.util.List;
import java.util.Optional;

public class User {
    private Long id;
    private String name;
    private String optionalName;
    private Integer age;
    private Address address;
    private Long[] childrenIdList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getOptionalName() {
        return Optional.ofNullable(optionalName);
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long[] getChildrenIdList() {
        return childrenIdList;
    }

    public void setChildrenIdList(Long[] childrenIdList) {
        this.childrenIdList = childrenIdList;
    }
}
