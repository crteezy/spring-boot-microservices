package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.model.Game;

@Controller
@RequestMapping("/games")
public class GameInfoController {

	@RequestMapping("/{gameId}")
	@ResponseBody
	public Game getGameInfo(@PathVariable("gameId") Long id){
		return new Game(id, "BattleField 1");
	}
}
