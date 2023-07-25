@Controller
	public class Job_VacancyController {
		
		@Autowired
		private Job_VacancyDao job_vacancyDao;
		
		@RequestMapping(path = "/home")
		public String home(Model m) {
			
			List<Job_Vacancy> list = job_vacancyDao.getAllJob_Vacancy();
			m.addAttribute("job_vacancylist",list);
			return "home";
			
		}
		@RequestMapping(path = "/addJob_Vacancy")
		public String add_Vacancy() {
			return "add_job_vacancy";
					
		}
		@RequestMapping(path = "createJob_Vacancy",method = RequestMethod.POST)
		public String createJob_Vacancy(@ModelAttribute Job_Vacancy job_vacancy,HttpSession session) {
			System.out.println(job_vacancy);
			
			int i = job_vacancyDao.saveJob_Vacancy(job_vacancy);
			session.setAttribute("msg","Register Sucessfully");
			return "redirect:/addJob_Vacancy";
		}

		
		@RequestMapping(path = "/editJob_Vacancy/{id}")
		public String editJob_Vacancy(@PathVariable int id,Model m){
		
			Job_Vacancy job_vacancy = job_vacancyDao.getJob_VacancyById(id);
			m.addAttribute("job_vacancy",job_vacancy);
			return "edit_job_vacancy";
			
		}
		
		@RequestMapping(path = "/update	Job_Vacancy",method = RequestMethod.POST)
		public String updateJob_Vacancy(@ModelAttribute Job_Vacancy job_vacancy,HttpSession session) {
			Job_VacancyDao.update(job_vacancy);
			session.setAttribute("msg","update Successfully");
			return "redirect:/home";
			
			
		}
		
		
		
		@RequestMapping(path = "/deleteJob_Vacancy/{id}")
		public String deleteJob_Vacancy(@PathVariable int id,HttpSession session) {
			job_vacancyDao.deleteJob_Vacancy(id);
			session.setAttribute("msg","Job_Vacancy Delete Successfully");
			return "redirect:/home";

		} 
		
	}	
	
}


	

