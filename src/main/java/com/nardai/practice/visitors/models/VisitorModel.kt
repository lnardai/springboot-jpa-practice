package com.nardai.practice.visitors.models

import java.net.InetAddress

data class Visitor(val name: String = "Rick", val ip: InetAddress = InetAddress.getByName("127.0.0.1"))
