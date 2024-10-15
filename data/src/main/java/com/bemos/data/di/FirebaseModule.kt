package com.bemos.data.di

import com.bemos.domain.interfaces.FirebaseAuthenticationRepository
import com.bemos.domain.interfaces.FirebaseCloudMessagingRepository
import com.bemos.domain.interfaces.FirebaseFirestoreRepository
import com.bemos.domain.interfaces.FirebaseRealtimeDatabaseRepository
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.messaging
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.storage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {
    @Provides
    fun provideFirebaseAuth() : FirebaseAuth {
        return Firebase.auth
    }

    @Provides
    fun provideFirebase() : FirebaseStorage {
        return Firebase.storage
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
    fun provideFirebaseMessaging() : FirebaseMessaging {
        return Firebase.messaging
    }

    @Provides
    fun provideFirebaseAuthenticationRepository(
        firebaseAuth: FirebaseAuth,
        firestore: FirebaseFirestore
    ) : FirebaseAuthenticationRepository {
        return com.bemos.data.firebase.FirebaseAuthenticationImpl(
            firebaseAuth = firebaseAuth,
            firebaseFirestore = firestore
        )
    }

    @Provides
    fun provideFirebaseFirestoreRepository(
        firebaseAuth: FirebaseAuth,
        firestore: FirebaseFirestore,
        firebaseStorage: FirebaseStorage
    ) : FirebaseFirestoreRepository {
        return com.bemos.data.firebase.FirebaseFirestoreImpl(
            firestore = firestore,
            firebaseAuth = firebaseAuth,
            firebaseStorage = firebaseStorage
        )
    }

    @Provides
    fun provideFirebaseReealtimeDatabaseRepository(
        firebaseDatabase: FirebaseDatabase,
        firebaseFirestore: FirebaseFirestore
    ) : FirebaseRealtimeDatabaseRepository {
        return com.bemos.data.firebase.FirebaseRealtimeDatabaseImpl(
            firebaseDatabase = firebaseDatabase,
            firestore = firebaseFirestore
        )
    }

    @Provides
    fun provideFirebaseCloudMessagingRepository(
        firebaseMessaging: FirebaseMessaging
    ) : FirebaseCloudMessagingRepository {
        return com.bemos.data.firebase.FirebaseCloudMessagingImpl(
            firebaseMessaging = firebaseMessaging
        )
    }
}