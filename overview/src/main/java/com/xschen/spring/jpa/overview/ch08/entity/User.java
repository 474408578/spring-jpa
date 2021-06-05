package com.xschen.spring.jpa.overview.ch08.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xschen
 */

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"createDate", "email"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty("my_name")
    private String name;

    private Instant createDate;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:SS")
    private Date updateDate;

    private String email;

    @JsonIgnore
    private String sex;

    @JsonCreator
    public User(@JsonProperty("email") String email) {
        System.out.println("其他业务逻辑");
        this.email = email;
    }

    @Transient
    @JsonAnySetter
    private Map<String, Object> other = new HashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getOther() {
        return other;
    }

}
