package com.suyf.parecelext.test

import com.suyf.parecelext.core.ParcelableExt

/**
 * kotlin data class每个字段都要赋值，这样才会重载出无参构造函数
 */
data class TestKotlinData constructor(
    @Transient val name: String? = null,
    val age: Int? = 0,
    val address: String? = null
) : ParcelableExt