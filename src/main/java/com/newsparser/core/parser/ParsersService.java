package com.newsparser.core.parser;

import com.newsparser.core.arango.NewsArangoRepository;
import com.newsparser.core.exception.NewsParserException;
import com.newsparser.core.parser.model.ParsedPostEntry;
//import com.newsparser.core.translate.TranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParsersService {

    NewsArangoRepository arangoRepository;

    List<Parser> parsers;

  //  TranslateService translateService;
    @Autowired
    public ParsersService(NewsArangoRepository arangoRepository, List<Parser> parsers/*, TranslateService translateService*/) {
        this.arangoRepository = arangoRepository;
        this.parsers = parsers;
     //   this.translateService = translateService;
    }

   // @Scheduled(fixedDelay = 10000)
    public void runPostParsers() {
        parsers.forEach(parser -> {
            try {
                List<ParsedPostEntry> parsedPost = parser.getPostListFromUrl();
                List<ParsedPostEntry> existedPosts = arangoRepository.getExistedPosts();
                parsedPost.removeAll(existedPosts);
                if (parsedPost.size()!= 0){
                    arangoRepository.insertEntrys(parsedPost);
                    updateTags();
                }
            } catch (IOException | NewsParserException exception) {
                exception.printStackTrace();
            }
        });
    }

    //@Scheduled(fixedDelay = 30000)
    public void runEachPostParser() throws IOException, InterruptedException {
        parsers.forEach(parser -> {
            try {
                List<ParsedPostEntry> filledPosts = parser.parseEachLink(
                        arangoRepository.getExistedPosts()
                                .stream().filter(
                                        post -> !post.isFullParseSuccess())
                                .limit(5)
                                .collect(Collectors.toList()));
                System.out.println(filledPosts);
              //  filledPosts.forEach(post -> translateService.rewrite(post.getTitle()));
                arangoRepository.fillEntrys(filledPosts);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });
    /*  parsers.forEach(parser -> {
            List<>parser.parseEachLink();
        }*/

    }

    protected void updateTags(){
        arangoRepository.undateTagLinks();
    }
}
