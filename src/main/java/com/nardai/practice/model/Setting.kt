package com.nardai.practice.model

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Setting(
                   @Id
                   val key: String = "N/A",
                   val text: String = "N/A") {
}

