package com.javarush.island.mikhailov.config.field;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PROTECTED)
public class Console {
    int showRows = Default.CONSOLE_SHOW_ROWS;
    int showCols = Default.CONSOLE_SHOW_COLS;
    int cellCharCount = Default.CONSOLE_CELL_CHAR_COUNT;
    int period = Default.PERIOD;
    int rows = Default.ROWS;
    int cols = Default.COLS;
    int percentAnimalSlim = Default.PERCENT_ANIMAL_SLIM;
    int percentPlantGrow = Default.PERCENT_PLANT_GROW;
    int width = Default.WINDOW_WIDTH;
    int height = Default.WINDOW_HEIGHT;
    int cellIconCount = Default.WINDOW_CELL_ICON_COUNT;
}
