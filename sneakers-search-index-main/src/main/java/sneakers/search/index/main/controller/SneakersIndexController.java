package sneakers.search.index.main.controller;

import org.apache.solr.common.SolrDocumentList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

import sneakers.common.api.provider.SolrHandleProvider;

/**
 * 
 * @author quicksandzn@gmail.com
 *
 *         sneakers index entrance
 */
@RestController
public class SneakersIndexController {


    @Reference(version = "1.0.0")
    private SolrHandleProvider solrHandleProvider;

    @GetMapping("/index")
    public SolrDocumentList searchIndex(@RequestParam(value = "title") String title,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size) {

        return solrHandleProvider.findByTitle(title, page, size);
    }

}
