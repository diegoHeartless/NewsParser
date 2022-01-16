package com.newsparser.core.arango;

import com.arangodb.springframework.annotation.Query;
import com.arangodb.springframework.repository.ArangoRepository;
import com.newsparser.core.parser.model.ParsedPostEntry;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsArangoRepository extends ArangoRepository<ParsedPostEntry, String> {

    @Query("FOR ent in @entrys INSERT ent IN ParsedPostEntry " +
            "let unTag = (\n" +
            "            FOR u IN @entrys \n" +
            "             for t in u.tags \n" +
            "             return DISTINCT t) \n" +
            "             for te in unTag \n" +
            "             upsert {tag:te} \n" +
            "            INSERT { tag: te }\n" +
            "              UPDATE { tag: te } in NewsTags ")
    public void insertEntrys(List<ParsedPostEntry> entrys);

    @Query("FOR ent in @entrys " +
            "for existed in ParsedPostEntry " +
            "filter ent._id == existed._id " +
            "update existed with {fullParseSuccess: true, articles: ent.articles} IN ParsedPostEntry")
    public void fillEntrys(List<ParsedPostEntry> entrys);

    @Query("FOR existed IN ParsedPostEntry " +
            "return existed")
    public List<ParsedPostEntry> getExistedPosts();

    @Query("LET fiveDaysAgo = @time\n" +
            "FOR post IN ParsedPostEntry\n" +
            "  FILTER DATE_DIFF(post.createdAt, fiveDaysAgo, 'day') >= 0\n" +
            "  REMOVE post IN ParsedPostEntry")
    public void cleanDatabase(String time);

    @Query("let unTag = (\n" +
            "  FOR u IN ParsedPostEntry\n" +
            "  for t in u.tags\n" +
            "  return DISTINCT t)\n" +
            "  for te in unTag\n" +
            "  upsert {tag:te} \n" +
            "  INSERT { tag: te }\n" +
            "    UPDATE { tag: te } in NewsTags ")
    public void updateTags();

    @Query("  FOR u IN ParsedPostEntry\n" +
            "  for tag in NewsTags\n" +
            "  for t in u.tags\n" +
            "    filter tag.tag==t\n" +
            "    INSERT {_from: u._id, _to: tag._id} in NewToTag")
    public void undateTagLinks();

}
