package com.eas.dbroom

import android.app.Application

class UsersApplication : Application() {
    lateinit var container: UsersContainer

    override fun onCreate() {
        super.onCreate()
        container = UsersContainer(this)
    }

}