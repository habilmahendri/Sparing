package com.habil.sparing.feature.lobby


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

import com.habil.sparing.R
import com.habil.sparing.adapter.LobbyAdapter
import com.habil.sparing.model.Lobby
import kotlinx.android.synthetic.main.fragment_lobby.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class LobbyFragment : Fragment(), LobbyContract.View {

    private var listLobby: MutableList<Lobby> = mutableListOf()
    private lateinit var presenter: LobbyPresenter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter = LobbyPresenter(this)
        presenter.getAllLobby()
    }

    override fun showAllLobby(lobby: MutableList<Lobby>) {
        lobby.reverse()
        listLobby.clear()
        listLobby.addAll(lobby)
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        rvLobby?.layoutManager = linearLayoutManager
        rvLobby?.adapter = LobbyAdapter(requireContext(), listLobby)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lobby, container, false)
    }


}
