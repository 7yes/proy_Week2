package com.sevenyes.pweek2c

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.sevenyes.pweek2c.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private  var calendarChanged= false
    private var fecha = Fecha(1980,0,1)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        binding.saveBtn.setOnClickListener {

            if (binding.titleBtn.text.length > 0 && binding.catBtn.text.length > 0) {
                if(!calendarChanged) fecha = getDate(binding.caledarEvent.date)
                val evento = Evento(binding.titleBtn.text.toString(), binding.catBtn.text.toString(),fecha)
                saveEvent(requireContext(),evento)
                findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment )
            }

        }

        binding.caledarEvent.setOnDateChangeListener {
                calendarView: CalendarView, year: Int, month: Int, day: Int ->
            fecha.year = year
            fecha.month = month
            fecha.day = day
            calendarChanged = true
        }



            return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            // Pruebas con el toast

        arguments?.let {
           // Toast.makeText(requireContext(), it.getString("Key"), Toast.LENGTH_SHORT).show()
            //Toast.makeText(requireContext(), it.getInt("int").toString(), Toast.LENGTH_SHORT).show()
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}