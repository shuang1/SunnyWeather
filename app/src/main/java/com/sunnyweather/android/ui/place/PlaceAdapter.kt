package com.sunnyweather.android.ui.place

import androidx.fragment.app.Fragment
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.sunnyweather.android.R
import com.sunnyweather.android.logic.model.Place

class PlaceAdapter(placeList: MutableList<Place>) : BaseQuickAdapter<Place,BaseViewHolder>(
    R.layout.place_item,placeList) {
    override fun convert(holder: BaseViewHolder, item: Place) {
        holder.setText(R.id.placeName, item.name)
        holder.setText(R.id.placeAddress, item.address)
    }

}
