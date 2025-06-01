package com.javarush.island.mikhailov.config;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PROTECTED)
public class Setting {
    public static final String SETTING_YAML = "/khmelov/setting.yaml";
}
