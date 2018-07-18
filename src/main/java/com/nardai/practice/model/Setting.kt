package com.nardai.practice.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Setting(@Id
                   @GeneratedValue
                   val id: Long = 0,
                   val key: String = "N/A",
                   val text: String = "N/A") {
    constructor(key: String, value: String) : this() {

    }
}

