package C17_Exception_File_Parsing.Author_Exception;

import java.util.ArrayList;
import java.util.List;

class Author{
    private Long id;
    private String name;
    private String email;
    private String password;
    private static Long static_count = 0L;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    Author(
            String name,
            String email,
            String password
    ){
        static_count++;
        this.id = static_count;
        this.name = name;
        this.email = email;
        this.password = password;
    }

}
