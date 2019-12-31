package com.demo.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.model.Catalog;

@Controller
@RequestMapping("/catalog")
public class GameCatalogController {

	@RequestMapping("/{userId}")
	@ResponseBody
	public List<Catalog> getCatalog(@PathVariable String userId) {

		return Collections.singletonList(new Catalog(1L, "Catalog 1", "Description 1", 4.0));
	}
}
