package com.couce3.lab2.web.screens.example;

import com.haulmont.cuba.gui.screen.*;
import com.couce3.lab2.entity.Example;

@UiController("lab2_Example.browse")
@UiDescriptor("example-browse.xml")
@LookupComponent("examplesTable")
@LoadDataBeforeShow
public class ExampleBrowse extends StandardLookup<Example> {
}