package com.sevenyes.pweek2c

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sevenyes.pweek2c.databinding.FragmentThirdBinding
import com.sevenyes.pweek2c.models.Evento
import com.sevenyes.pweek2c.models.EventsData

class ThirdFragment : Fragment() {
    private var evPos: Int = 0
    private var event: Evento? = null

    private var _binding: FragmentThirdBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            evPos = it.getInt("ZEY")
            event = EventsData.getEvent(evPos)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)

        var dayLeft = binding.calendarTxt.date
        binding.titleTxt.text = event?.title
        binding.catTxt.text = event?.cat
        dayLeft = putDate(event!!.fecha) - dayLeft
        dayLeft = (dayLeft/86400000)

        binding.daysLeftCounter.text = dayLeft.toString()
        binding.calendarTxt.date = putDate(event!!.fecha)

        binding.daysLeftCounter.text = "$dayLeft days left"

        // Inflate the layout for this fragment
        return binding.root
    }
}