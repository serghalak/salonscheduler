package com.salon.datasourcebeans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MySqlDataSource {

    private String username;
    private String password;
    private String url;


}
