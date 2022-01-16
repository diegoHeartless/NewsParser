package com.newsparser.core;

import com.newsparser.core.arango.NewsArangoRepository;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CleanerService {

    NewsArangoRepository arangoRepository;

    SimpleDateFormat formatter;

    public CleanerService(NewsArangoRepository arangoRepository, SimpleDateFormat formatter) {
        this.arangoRepository = arangoRepository;
        this.formatter = formatter;
    }

 //   @Scheduled(fixedDelay = 10000)
    public void runCleaner() {
        Date date = DateUtils.addDays(new Date(),-7);
        arangoRepository.cleanDatabase(formatter.format(date));
    }
}
