package com.redvelvet.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.redvelvet.repository.source.RealTimeDataSource
import javax.inject.Inject


class FirebaseDataSource @Inject constructor(
    private val fireStore: FirebaseFirestore,
    private val auth: FirebaseAuth
) : RealTimeDataSource {

}