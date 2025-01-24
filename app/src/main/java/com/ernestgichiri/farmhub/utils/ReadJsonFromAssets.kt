package com.ernestgichiri.farmhub.utils

import android.content.Context
import com.ernestgichiri.farmhub.EcommerceApplication
import java.io.BufferedReader
import java.io.InputStreamReader

object ReadJSONFromAssets {
    fun readFile(fileName: String): String {
        val context = EcommerceApplication.getContext()
        val stringBuilder = StringBuilder()
        try {
            val inputStream = context.assets.open(fileName)
            val reader = BufferedReader(InputStreamReader(inputStream))
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                stringBuilder.append(line)
            }
            reader.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return stringBuilder.toString()
    }
}
