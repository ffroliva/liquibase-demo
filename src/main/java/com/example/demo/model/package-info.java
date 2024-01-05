// Configuration adapted from Java Persistence with Hibernate 2nd Edition, p540
@org.hibernate.annotations.GenericGenerator(
        name = "my_sequence",
        strategy = "enhanced-sequence",
        parameters = {
                @org.hibernate.annotations.Parameter(
                        name = "sequence_name",
                        value = "my_sequence"
                ),
                @org.hibernate.annotations.Parameter(
                        name = "increment_size",
                        value = "100"
                ),
                @org.hibernate.annotations.Parameter(
                        name = "optimizer",
                        value = "pooled-lo"
                )
        })
package com.example.demo.model;