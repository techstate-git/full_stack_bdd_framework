package utils.POJOS;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)

public class CustomerPojo {
        private String firstName;
        private String lastName;
        private String phone;
        private List<String> addresses;
    }


