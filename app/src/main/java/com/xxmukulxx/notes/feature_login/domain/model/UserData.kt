package com.xxmukulxx.notes.feature_login.domain.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


class InvalidUserException(message: String) : Exception(message)
//
//@Entity
//data class UserData(
//    var token: String,
//    var email: String,
//    var username: String,
//    @PrimaryKey
//    var id: String
//)

data class UserReq(
    @SerializedName("email")
    var email: String = "",
    @SerializedName("password")
    var password: String = "",
)

@Entity
data class UserData(
    @PrimaryKey
    @SerializedName("token")
    var token: String,
    @SerializedName("user")
    @Embedded
    var user: User?,
    @SerializedName("error")
    var error: String?,
)

data class User(
    @SerializedName("email")
    var email: String = "",
    @SerializedName("_id")
    var id: String = "",
    @SerializedName("name")
    var name: String = ""
)

//object UserDataMapper {
//    fun fromUserResToUserData(res: UserData?): UserData? {
//        return res?.user?.let {
//            UserData(
//                token = res.token,
//                username = it.name,
//                email = it.email,
//                id = it.id
//            )
//        } ?: run {
//            null
//        }
//    }
//}