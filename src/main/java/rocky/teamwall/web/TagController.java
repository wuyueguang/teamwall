package rocky.teamwall.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import rocky.teamwall.dto.JsonResult;
import rocky.teamwall.dto.TagDTO;
import rocky.teamwall.entity.Tag;
import rocky.teamwall.service.TagService;

@Controller
@RequestMapping("/tag") //url:/模块/资源/细分，例如/v1/tag/{uid}/taglist
public class TagController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//自动注入Service
	@Autowired
	private TagService tagService;
	
	@ResponseBody //spring根据此注解，自动返回json
	@RequestMapping(value = "/{uid}/taglist", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
	
	public TagDTO tagList(@PathVariable("uid")String uid){
		TagDTO result;
		try{
			List<Tag> list = tagService.getTagList(uid);
			result = new TagDTO(true, list);
		}
		catch(Exception e){
			logger.error(e.getMessage(), e);
			result = new TagDTO(false, e.getMessage());
		}
		
		return result;
	}
	/*
	public JsonResult< List<Tag> > tagList(@PathVariable("uid")String uid){
		JsonResult< List<Tag> > result;
		try{
			List<Tag> list = tagService.getTagList(uid);
			result = new JsonResult< List<Tag> >(true, list);
		}
		catch(Exception e){
			logger.error(e.getMessage(), e);
			result = new JsonResult< List<Tag> >(false, e.getMessage());
		}
		
		return result;
	}
	*/
	/*
		curl http://127.0.0.1:8080/teamwall/tag/123/taglist
	 */
	
	@ResponseBody //spring根据此注解，自动返回json
	@RequestMapping(value = "/{uid}/newtag", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	
	public TagDTO newTag(@PathVariable("uid")String uid,
										@RequestParam("tag")String tag){
		TagDTO result;
		try{
			int count = tagService.addTag(uid, tag);
			result = new TagDTO(true, new Integer(count));
		}
		catch(Exception e){
			logger.error(e.getMessage(), e);
			result = new TagDTO(false, e.getMessage());
		}
		
		return result;
	}
	/*
	public JsonResult< Integer > newTag(@PathVariable("uid")String uid,
										@RequestParam("tag")String tag){
		JsonResult< Integer > result;
		try{
			int count = tagService.addTag(uid, tag);
			result = new JsonResult< Integer >(true, new Integer(count));
		}
		catch(Exception e){
			logger.error(e.getMessage(), e);
			result = new JsonResult< Integer >(false, e.getMessage());
		}
		
		return result;
	}
	*/
	/*
		curl http://127.0.0.1:8080/teamwall/tag/123/newtag -d tag="tag name"
	 */
}
