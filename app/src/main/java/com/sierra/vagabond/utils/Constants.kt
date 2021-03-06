package com.sierra.vagabond.utils

import android.content.Context

const val FACILITY_ID = "FacilityID"
const val FACILITY_NAME = "FacilityName"
const val IS_RESERVABLE = "Reservable"
const val IS_ENABLED = "Enabled"

const val USER_WATCH_ID = "user_id"
const val WATCH_FACILITY_ID = "facility_id"
const val WATCH_FACILITY_NAME = "facility_name"
const val START_DATE = "start_date"
const val END_DATE = "end_date"

const val WATCH_TOKEN = "token"
const val WATCH_ID = "watch_id"

const val REGISTER_TOKEN = "registerToken"
const val FCM_TOKEN = "fcm_token"

const val EXCEPTION_STRING_VIEWMODEL = "ViewModel class not found"
const val EXCEPTION_STRING_TOKEN = "TokenError"

const val IMG_TITLE = "Title"
const val IMG_HEIGHT = "Height"
const val IMG_WIDTH = "Width"
const val IMG_URL = "URL"

const val REC_AREA_ID = "RecAreaID"
const val REC_AREA_NAME = "RecAreaName"
const val REC_AREA_DESC = "RecAreaDescription"
const val REC_AREA_DIRS = "RecAreaDirections"
const val REC_AREA_PHONE = "RecAreaPhone"
const val REC_AREA_EMAIL = "RecAreaEmail"

const val REC_AREA_MEDIA = "MEDIA"
const val REC_AREA_FACILITIES = "FACILITY"
const val AREAS_DATA = "RECDATA"

const val RC_AREAS_ENDPOINT = "recareas/"
const val RC_BASE_ENDPOINT = "https://ridb.recreation.gov/api/v1/"
const val RC_FACILITIES_ENDPOINT = "$RC_AREAS_ENDPOINT{RecAreaID}/facilities"
const val QUERY = "query"
const val FULL = "full"
const val ACTIVITY = "activity"
const val BY_NAME = "Name"
const val SORT = "sort"
const val API_KEY = "apikey"
const val CAMPING = "CAMPING"

/*const val CREATE_WATCH = "create_watch"*/
const val CREATE_WATCH = "createWatch"
const val DELETE_WATCH = "deleteWatch"
const val GET_WATCHES = "getWatches"
//const val GC_BASE_ENDPOINT = "https://us-central1-sierra-236907.cloudfunctions.net/"
const val GC_BASE_ENDPOINT = "https://us-central1-sierra-api-266504.cloudfunctions.net/"

const val IMAGE_URL = "image_url"
const val AREA = "area"

const val NAME = "DEVICE_PREFS"
const val MODE = Context.MODE_PRIVATE

// const val ACCEPT_HEADER = "Accept: application/json"
const val CONTENT_TYPE = "Content-type: application/json"

const val DB_NAME = "areas.db"
const val TABLE_NAME = "recreational_areas"
const val SELECT_ALL = "SELECT * FROM $TABLE_NAME"
const val SELECT_ONE = "SELECT * FROM $TABLE_NAME WHERE recAreaID = :rec_area_id"
const val DELETE_ALL = "DELETE FROM $TABLE_NAME"


