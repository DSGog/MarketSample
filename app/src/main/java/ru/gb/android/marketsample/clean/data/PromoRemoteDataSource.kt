package ru.gb.android.marketsample.clean.data

import ru.gb.android.marketsample.layered.common.promo.data.PromoApiService
import ru.gb.android.marketsample.layered.common.promo.data.PromoDto

class PromoRemoteDataSource(
    private val promoApiService: PromoApiService,
) {
    suspend fun getPromos(): List<PromoDto> {
        return promoApiService.getPromos()
    }
}
