package com.bemos.bemogram.di

import com.bemos.bemogram.data.firebase.FirebaseAuthenticationImpl
import com.bemos.bemogram.domain.interfaces.FirebaseAuthenticationRepository
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {
    @Provides
    fun provideFirebaseAuth() : FirebaseAuth {
        return Firebase.auth
    }

    @Provides
    fun provideFirebaseDatabase() : FirebaseDatabase {
        return Firebase.database
    }

    @Provides
    fun provideFirebaseFirestore() : FirebaseFirestore {
        return Firebase.firestore
    }

    @Provides
    fun provideFirebaseAuthenticationRepository(
        firebaseAuth: FirebaseAuth,
        firestore: FirebaseFirestore
    ): FirebaseAuthenticationRepository {
        return FirebaseAuthenticationImpl(
            firebaseAuth = firebaseAuth,
            firebaseFirestore = firestore
        )
    }
}