package com.example.lab4danilov

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    private var titles = arrayOf(
        "Барак Обэма", "Александр Пушкин", "Дмитрий Менделеев", "Стэн Ли", "Кристофер Ллойд",
        "Джеки Чан", "Стив Джобс", "Илон Макес", "Альберт Эйнштейн", "Томас Эдисон"
    )
    private var years = arrayOf(
        "1961 г. - н.в.",
        "1799 г. - 1837 г.",
        "1834 г. - 1907 г.",
        "1922 г. - 2018 г.",
        "1938 г. - н.в.",

        "1954 г. - н.в.",
        "1955 г. - 2011 г.",
        "1971 г. - н.в.",
        "1879 г. - 1955 г.",
        "1847 г. - 1931 г."
    )
    private var details = arrayOf(
        "Американский государственный и политический деятель, 44-й президент США с 20 января 2009 года по 20 января 2017 года. Лауреат Нобелевской премии мира 2009 года",
        "Русский поэт, драматург и прозаик, заложивший основы русского реалистического направления, литературный критик и теоретик литературы, историк, публицист, журналист; один из самых авторитетных литературных деятелей первой трети XIX века",
        "Русский ученый-энциклопедист, открывший периодический закон химических элементов",
        "Американский писатель, актёр, продюсер, телеведущий, сценарист, редактор и создатель множества персонажей комиксов, бывший президент и председатель совета директоров издательства Marvel Comics",
        "Американский актёр кино и телевидения. Обладатель трёх премий «Эмми». Наиболее известен по роли доктора Эмметта Брауна в кинотрилогии «Назад в будущее»",

        "Гонконгский актёр, каскадёр, кинорежиссёр, продюсер, сценарист, постановщик трюков и боевых сцен, певец, филантроп, мастер боевых искусств",
        "Американский предприниматель, изобретатель и промышленный дизайнер, получивший широкое признание в качестве пионера эры информационных технологий",
        "Основатель, совладелец, генеральный директор и главный инженер компании SpaceX; генеральный директор и главный идейный вдохновитель компании Tesla",
        "Физик-теоретик, один из основателей современной теоретической физики, лауреат Нобелевской премии по физике 1921 года, общественный деятель-гуманист",
        "Американский изобретатель и предприниматель, получивший в США 1093 патента и около 3 тысяч в других странах мира; создатель фонографа; усовершенствовал телеграф, телефон, киноаппаратуру, разработал один из первых коммерчески успешных вариантов электрической лампы накаливания",
    )
    private var gender = arrayOf(
        "МУЖЧИНА", "МУЖЧИНА", "МУЖЧИНА", "МУЖЧИНА", "МУЖЧИНА",
        "МУЖЧИНА", "МУЖЧИНА", "МУЖЧИНА", "МУЖЧИНА", "МУЖЧИНА"
    )
    private val images = intArrayOf(
        R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5,
        R.drawable.img6, R.drawable.img7, R.drawable.img8, R.drawable.img9, R.drawable.img10
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        holder.itemYears.text = years[position]
        holder.itemDetail.text = details[position]
        holder.itemGender.text = gender[position]
        holder.itemImage.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemYears: TextView
        var itemGender: TextView
        var itemDetail: TextView
        var itemLike: ImageView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemYears = itemView.findViewById(R.id.item_years)
            itemGender = itemView.findViewById(R.id.item_gender)
            itemDetail = itemView.findViewById(R.id.item_detail)
            itemLike = itemView.findViewById(R.id.like_button)

            itemView.setOnClickListener {
                val position: Int = adapterPosition

                Toast.makeText(
                    itemView.context,
                    "Нажата карточка: ${titles[position]}",
                    Toast.LENGTH_LONG
                ).show()
            }
            itemLike.setOnClickListener {
                val position: Int = adapterPosition

                Toast.makeText(
                    itemView.context,
                    "Нажат лайк: ${titles[position]}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}