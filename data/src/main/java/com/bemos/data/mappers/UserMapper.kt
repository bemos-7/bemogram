package com.bemos.data.mappers

import com.bemos.data.models.User
import com.bemos.domain.model.UserDomain

object UserMapper {

    fun toDomain(user: User) : UserDomain {
        return UserDomain(
            userId = user.userId,
            username = user.username,
            bio = user.bio,
            imageUrl = user.imageUrl,
            name = user.name,
            surname = user.surname,
            notificationToken = user.notificationToken,
            followers = user.followers,
            following = user.following,
            publications = user.publications,
            totalPosts = user.totalPosts,
            url = user.url,
            email = user.email,
            password = user.password
        )
    }

    fun toUser(userDomain: UserDomain) : User {
        return User(
            userId = userDomain.userId,
            username = userDomain.username,
            bio = userDomain.bio,
            imageUrl = userDomain.imageUrl,
            name = userDomain.name,
            surname = userDomain.surname,
            notificationToken = userDomain.notificationToken,
            followers = userDomain.followers,
            following = userDomain.following,
            publications = userDomain.publications,
            totalPosts = userDomain.totalPosts,
            url = userDomain.url,
            email = userDomain.email,
            password = userDomain.password
        )
    }

}