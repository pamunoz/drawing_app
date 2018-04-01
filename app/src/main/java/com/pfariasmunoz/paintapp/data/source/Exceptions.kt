package com.pfariasmunoz.paintapp.data.source

open class DataSourceException(message: String? = null) : Exception(message)

class LocalDataNotFoundException : DataSourceException("Data not found in local data source")

class RemoteDataNotFoundException : DataSourceException("Data not found in remote data source")