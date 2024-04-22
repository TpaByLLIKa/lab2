package com.couce3.lab2.web.screens.example;

import com.haulmont.cuba.gui.screen.*;
import com.couce3.lab2.entity.Example;

@UiController("lab2_Example.edit")
@UiDescriptor("example-edit.xml")
@EditedEntityContainer("exampleDc")
@LoadDataBeforeShow
public class ExampleEdit extends StandardEditor<Example> {
}