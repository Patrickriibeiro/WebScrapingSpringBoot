package com.pro.webScraping.controller;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "v2/scappercall/")
@Slf4j
public class ScapperController {

	@GetMapping(value = "/exec")
	public void executarBusca() {

		String url = "https://www.nfl.com/stats/player-stats/category/passing/2020/REG/all/passingyards/DESC";
		log.info("Url de conexão : " + url);

		// Conectando na url
		try {
			Document doc = Jsoup.connect(url).get();
			
		//Tentando pegas o titulo pela class
			
			Element titulo = doc.getElementsByClass("nfl-c-content-header__roofline").first();
			log.info("titulo : " + titulo.text());
		
		
		} catch (IOException e) {
			log.error("erro na conexão : " + e);
		}
	}

}
