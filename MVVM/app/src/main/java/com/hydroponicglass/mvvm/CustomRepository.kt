package com.hydroponicglass.mvvm

class CustomRepository() {
    private val data: CustomDataClass = CustomDataClass("Hello", "World")

    fun getData(): CustomDataClass {
        return data
    }
}