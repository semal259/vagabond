package com.sierra.vagabond.data.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.sierra.vagabond.utils.AREAS_DATA

data class Wrapper<T>(@field:SerializedName(AREAS_DATA) @field:Expose val data: List<T>)