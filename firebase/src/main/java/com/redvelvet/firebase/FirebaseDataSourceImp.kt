package com.redvelvet.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.redvelvet.repository.FirebaseDataSource
import javax.inject.Inject


class FirebaseDataSourceImp @Inject constructor(
    private val fireStore: FirebaseFirestore,
    private val auth: FirebaseAuth
) : FirebaseDataSource {

}