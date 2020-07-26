package kr.co.tjoeun.daily10minute_20200719.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kr.co.tjoeun.daily10minute_20200719.R
import kr.co.tjoeun.daily10minute_20200719.datas.Project
import kr.co.tjoeun.daily10minute_20200719.datas.Proof
import java.text.SimpleDateFormat

class ProofAdapter(
    val mContext:Context,
    resId:Int,
    val mList:List<Proof>) : ArrayAdapter<Proof>(mContext, resId, mList) {

    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if (tempRow == null) {
            tempRow = inf.inflate(R.layout.proof_list_item, null)
        }

        val row = tempRow!!

        val userProfileImg = row.findViewById<ImageView>(R.id.userProfileImg)
        val userNickNameTxt = row.findViewById<TextView>(R.id.userNickNameTxt)
        val proofTimeTxt = row.findViewById<TextView>(R.id.proofTimeTxt)
        val contentTxt = row.findViewById<TextView>(R.id.contentTxt)
        val proofImg = row.findViewById<ImageView>(R.id.proofImg)

        val data = mList[position]

        contentTxt.text = data.content

        userNickNameTxt.text = data.user.nickName
        Glide.with(mContext).load(data.user.profileImageList[0].imageUrl).into(userProfileImg)

//        인증일시 : 2020년 6월 9일 오전 2시 8분 양식으로 출력
//        data의 proofTime 변수를 활용하자
//        String으로 변환 => SimpleDateFormat의 format 기능 활용

        val sdf = SimpleDateFormat("yyyy년 M월 d일 a h시 m분")
        proofTimeTxt.text = sdf.format(data.proofTime.time)



        return row
    }


}