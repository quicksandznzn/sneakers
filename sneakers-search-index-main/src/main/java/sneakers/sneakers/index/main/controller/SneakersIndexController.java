package sneakers.sneakers.index.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sneakers.common.api.model.PageInfo;
import sneakers.sneakers.index.main.field.SolrField;
import sneakers.sneakers.index.main.service.solr.SolrHandleService;

/**
 * 
 * @author quicksandzn@gmail.com
 *
 *         sneakers index entrance
 */
@RestController
public class SneakersIndexController {


    @Autowired
    private SolrHandleService solrHandleService;

    @GetMapping("/index")
    public Page<PageInfo> searchIndex(@RequestParam(value = "title") String title,
            @PageableDefault(page = 1, size = 10,
                    sort = {SolrField.SORT_SCORE, SolrField.SORT_RELEASEDATE},
                    direction = Sort.Direction.DESC) Pageable pageable) {

        return solrHandleService.findByTitle(title, pageable);
    }
}
