package com.jedun.teamaptexercise.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jedun.teamaptexercise.databinding.FragmentHomeBinding
import com.jedun.teamaptexercise.ui.SuccessBottomSheet
import com.jedun.teamaptexercise.ui.home.adapters.SavingsListAdapter
import com.jedun.teamaptexercise.utils.DataCenter

class HomeFragment : Fragment(), SuccessBottomSheet.BottomSheetListener {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    private lateinit var savingsListAdapter: SavingsListAdapter
    private lateinit var savingsRecyclerView: RecyclerView
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        val root: View = binding.root

        savingsListAdapter = SavingsListAdapter()
        savingsRecyclerView = binding.fragmentHomeAddedCardRecyclerView
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        savingsRecyclerView.apply {
            adapter = savingsListAdapter
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        }

        binding.requestClickListener = View.OnClickListener {
            homeViewModel.addRequest()
        }


        homeViewModel.observableBalance.observe(viewLifecycleOwner, { savingsList ->

            val totalAccount =
                savingsList.fold(0, { acc, savings -> acc + savings.amount })

            val percentageBalance = ((totalAccount * 100) / 1000)
            savingsListAdapter.submitList(savingsList)

            savingsListAdapter.notifyDataSetChanged()


            binding.apply {
                added = savingsList[0].amount.toString()
                balance = totalAccount.toString()
                progress = percentageBalance
            }

            if (percentageBalance == 100) {
                openBottomDialog()
            }

        })
    }

    private fun openBottomDialog() {
        val commentBottomDialog =
            SuccessBottomSheet.newInstance("You have fully completed your goal. ")
        commentBottomDialog.show(childFragmentManager, "commentBottomDialog")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCloseListener() {

    }
}