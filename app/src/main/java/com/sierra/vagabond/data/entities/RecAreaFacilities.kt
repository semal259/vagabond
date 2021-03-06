package com.sierra.vagabond.data.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.sierra.vagabond.utils.FACILITY_ID
import com.sierra.vagabond.utils.FACILITY_NAME
import com.sierra.vagabond.utils.IS_ENABLED
import com.sierra.vagabond.utils.IS_RESERVABLE

data class RecAreaFacilities(@field:SerializedName(FACILITY_ID) @field:Expose val facilityId: String,
                             @field:SerializedName(FACILITY_NAME) @field:Expose val facilityName: String,
                             @field:SerializedName(IS_RESERVABLE) @field:Expose val isReservable: Boolean,
                             @field:SerializedName(IS_ENABLED) @field:Expose val isEnabled: Boolean)