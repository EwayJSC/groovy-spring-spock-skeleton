package com.eway.demo.model

import groovy.transform.Canonical
import groovy.transform.EqualsAndHashCode
import groovy.transform.Sortable
import groovy.transform.ToString
import groovy.transform.TupleConstructor
import groovy.transform.builder.Builder
import groovy.transform.builder.SimpleStrategy

@Canonical
@TupleConstructor
//@MapConstructor
@EqualsAndHashCode
@ToString(ignoreNulls=true)
@Sortable
@Builder(builderStrategy=SimpleStrategy)
class Person {
    String name
    int age
}
