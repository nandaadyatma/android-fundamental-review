package com.plcoding.cryptocurrencyappyt

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp //agar dagger hilt dapat tahu dan mengakses app ini
class CoinApplication : Application()